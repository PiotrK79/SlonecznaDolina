import { useEffect, useState } from "react";

interface Props {
  itemName: string;
  amount: number;
}

export default function CIncomeComponents({
  itemName: name,
}: Props) {
  const items = ["Narty", "Kijki", "Buty", "Snowboard", "Lekcja", "Karnet"];

  const [delta, setDelta] = useState<string>("1");

  const [sold, setSold] = useState(() => {
    const saved = localStorage.getItem("klucz")
    return saved ? Number(saved) : 0
  });

  useEffect(() =>{
    localStorage.setItem("klucz", String(sold))
  }, [sold])

  

  const addDelta = () => {
    const n = Number(delta);
    if (!Number.isFinite(n)) return;
    if (n < 0) return;
    setSold((s) => s + n);
  };

  return (
    <>
      <h4>{name}</h4>
      <p>Sprzedane: {sold}</p>

      <div style={{ display: "flex", gap: 8, alignItems: "center" }}>
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
