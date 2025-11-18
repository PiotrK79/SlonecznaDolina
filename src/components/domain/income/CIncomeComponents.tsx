import { useEffect, useState } from "react";
import "./CIncomeComponents.css";

interface Props {
  itemName: string;
  reportId: string;
}

export default function CIncomeComponents({ itemName, reportId }: Props) {
  const [delta, setDelta] = useState<string>("1");
  const [sold, setSold] = useState<number>(0);

  useEffect(() => {
    const reportsJSON = localStorage.getItem("reports");
    if (!reportsJSON) return;

    const reports = JSON.parse(reportsJSON);
    const index = reports.findIndex((r: any) => r.id === reportId);
    if (index === -1) return;

    const existing = reports[index].sales?.[itemName] ?? 0;
    setSold(existing);
  }, [itemName, reportId]);

  const updateSales = (value: number) => {
    setSold(value);

    const reportsJSON = localStorage.getItem("reports");
    if (!reportsJSON) return;

    const reports = JSON.parse(reportsJSON);
    const index = reports.findIndex((r: any) => r.id === reportId);
    if (index === -1) return;

    if (!reports[index].sales) reports[index].sales = {};

    reports[index].sales[itemName] = value;

    localStorage.setItem("reports", JSON.stringify(reports));
  };

  const addDelta = () => {
    const amount = Number(delta);
    // if (!Number.isFinite(amount) || amount < 0) return;
    updateSales(sold + amount);
  };

  return (
  <li className="income-item">
    <div className="income-info">
      <h4>{itemName}:</h4>
      <p>Sprzedane: {sold}</p>
    </div>

    <div className="income-input">
      <input
        type="number"
        min={0}
        value={delta}
        onChange={(e) => setDelta(e.target.value)}
        onKeyDown={(e) => e.key === "Enter" && addDelta()}
      />
      <button onClick={addDelta} disabled={delta.trim() === ""}>
        Dodaj wartość
      </button>
    </div>
  </li>
);

}
