import { useEffect, useState } from "react";
import "./CIncomeComponents.css";

interface Props {
  itemName: string;
  amount: number;
}

export default function CIncomeComponents({ itemName: name }: Props) {
  const [delta, setDelta] = useState<string>("1");
  const [sold, setSold] = useState<number>(0);

  useEffect(() => {
    const activeReportId = localStorage.getItem("activeReportId");

    if (activeReportId) {
      const saved = localStorage.getItem(`sales_${activeReportId}_${name}`);
      setSold(saved ? Number(saved) : 0);
    } else {

      setSold(0);
    }
  }, [name]);

  useEffect(() => {
    const activeReportId = localStorage.getItem("activeReportId");
    if (activeReportId) {
      localStorage.setItem(`sales_${activeReportId}_${name}`, String(sold));
    }
  }, [sold, name]);

  const addDelta = () => {
    const n = Number(delta);
    if (!Number.isFinite(n) || n < 0) return;
    setSold((s) => s + n);
  };

  return (
    <>
      <div className="income-info">
        <h4>{name}: </h4>
        <p>Sprzedane: {sold}</p>
      </div>

      <div className="income-input">
        <input
          type="number"
          inputMode="numeric"
          min={0}
          step={1}
          placeholder="Wpisz wartość"
          value={delta}
          onChange={(e) => setDelta(e.target.value)}
          onKeyDown={(e) => {
            if (e.key === "Enter") addDelta();
          }}
          style={{ width: 120 }}
        />
        <button onClick={addDelta} disabled={delta.trim() === ""}>
          Dodaj wartość
        </button>
      </div>
    </>
  );
}
