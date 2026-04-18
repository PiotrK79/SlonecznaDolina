import { useState, useEffect } from "react";
import CRaportComponents from "../domain/reports/CRaportComponents";
import "./Reports.css";

interface Report {
  id: string;
  name: string;
  date: string;
  instructors?: Record<string, Record<string, string>>;
  sales?: Record<string, number>;
}

export default function Reports() {
  const [reports, setReports] = useState<Report[]>([]);
  const [activeReportId, setActiveReportId] = useState<string | null>(null);
  const [showForm, setShowForm] = useState(false);
  const [newReport, setNewReport] = useState({ name: "", date: "" });

  useEffect(() => {
    try {
      const savedReports = localStorage.getItem("reports");
      const active = localStorage.getItem("activeReportId");

      if (savedReports) {
        const parsed = JSON.parse(savedReports);
        if (Array.isArray(parsed)) {
          setReports(parsed);
        }
      }
      if (active) {
        setActiveReportId(active);
      }
    } catch (err) {
      console.error("Błąd przy wczytywaniu raportów z localStorage:", err);
    }
  }, []);

  useEffect(() => {
    if (reports.length > 0) {
      localStorage.setItem("reports", JSON.stringify(reports));
    }
  }, [reports]);

  useEffect(() => {
    if (activeReportId) {
      localStorage.setItem("activeReportId", activeReportId);
    }
  }, [activeReportId]);

  const setActiveReport = (id: string) => {
    setActiveReportId(id);
  };

  const addReport = () => {
    if (!newReport.name.trim() || !newReport.date.trim()) return;

    const report: Report = {
      id: Date.now().toString(),
      ...newReport,
      instructors: {},
      sales: {},
    };

    const updatedReports = [...reports, report];
    setReports(updatedReports);
    setActiveReport(report.id); 
    setNewReport({ name: "", date: "" });
    setShowForm(false);

    localStorage.setItem("reports", JSON.stringify(updatedReports));
    localStorage.setItem("activeReportId", report.id);
  };

  const deleteReport = (id: string) => {
    const filtered = reports.filter((r) => r.id !== id);
    setReports(filtered);
    localStorage.setItem("reports", JSON.stringify(filtered));

    if (activeReportId === id) {
      localStorage.removeItem("activeReportId");
      setActiveReportId(null);
    }
  };

  return (
    <div className="reports-container">
      <button className = "new-report-button" onClick={() => setShowForm(true)}>Nowy raport</button>
      {showForm && (
        <div className="new-report-modal">
          <h3>Nowy raport</h3>
          <input
            type="text"
            placeholder="Nazwa raportu"
            value={newReport.name}
            onChange={(e) =>
              setNewReport({ ...newReport, name: e.target.value })
            }
          />
          <input
            type="date"
            value={newReport.date}
            onChange={(e) =>
              setNewReport({ ...newReport, date: e.target.value })
            }
          />
          <div className="form-buttons">
            <button onClick={addReport}>Zatwierdź</button>
            <button onClick={() => setShowForm(false)}>Anuluj</button>
          </div>
        </div>
      )}

      <div className="reports-list">
        {reports.length === 0 && <p>Brak raportów. Utwórz nowy, aby rozpocząć.</p>}
        {reports.map((r) => (
          <CRaportComponents
            key={r.id}
            raport={r}
            onDelete={deleteReport}
            onEdit={() => setActiveReport(r.id)}
            active={r.id === activeReportId}
          />
        ))}
      </div>
    </div>
  );
}
