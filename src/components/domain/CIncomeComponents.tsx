import { useState } from "react"

type RentalComponentsProps = {
  name: string
  initialSold?: number
}

export default function CIncomeComponents({ name, initialSold = 0 }: RentalComponentsProps) {
  const [sold, setSold] = useState<number>(initialSold)   // ✅ zwykłe useState zamiast persistent
  const [delta, setDelta] = useState<string>("1")

  const addDelta = () => {
    const n = Number(delta)
    if (!Number.isFinite(n)) return
    if (n < 0) return
    setSold((s) => s + n)
  }

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
          onKeyDown={(e) => { if (e.key === 'Enter') addDelta() }}
          style={{ width: 120 }}
        />
        <button onClick={addDelta} disabled={delta.trim() === ""}>
          Dodaj wartość
        </button>
      </div>
    </>
  )
}
