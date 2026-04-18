import "./CRaportComponents.css";

interface Props {
  raport: { id: string; name: string; date: string };
  onDelete: (id: string) => void;
  onEdit: () => void;
  active: boolean;
}

export default function CRaportComponents({
  raport,
  onDelete,
  onEdit,
  active,
}: Props) {
  return (
    <div className={`raport-card ${active ? "active" : ""}`}>
      <div className="raport-info">
        {/* {active && <h3 className="active-tag">Aktywny</h3>} */}
        <h4>{raport.name}</h4>
        <p>Data: {raport.date}</p>
      </div>

      <div className="raport-buttons">
        <button onClick={onEdit}>Edycja</button>
        <button>Szczegóły</button>
        <button>PDF</button>
        <button onClick={() => onDelete(raport.id)}>Usuń</button>
      </div>
    </div>
  );
}
