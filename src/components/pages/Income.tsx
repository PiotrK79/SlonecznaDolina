import { useEffect, useState } from "react";
import CIncomeComponents from "../domain/income/CIncomeComponents";
import "./Income.css";

interface Report {
  id: string;
  name: string;
  date: string;
  instructors?: Record<string, Record<string, string>>;
  sales?: Record<string, number>;
}

function Income() {
  const [activeReport, setActiveReport] = useState<Report | null>(null);

  useEffect(() => {
    const reportsJSON = localStorage.getItem("reports");
    const activeId = localStorage.getItem("activeReportId");

    if (!reportsJSON || !activeId) {
      setActiveReport(null);
      return;
    }

    const reports: Report[] = JSON.parse(reportsJSON);
    const found = reports.find((r) => r.id === activeId);

    setActiveReport(found || null);
  }, []);

  if (!activeReport) {
    return <h2>Najpierw wybierz lub stwórz raport w zakładce Raporty.</h2>;
  }

  return (
    <div className="income-menu">
      <div className="rental-office">
        <h2>Wypożyczalnia</h2>
        <ul>
          <CIncomeComponents reportId={activeReport.id} itemName="Narty" />
          <CIncomeComponents reportId={activeReport.id} itemName="Buty" />
          <CIncomeComponents reportId={activeReport.id} itemName="Kijki" />
          <CIncomeComponents reportId={activeReport.id} itemName="Snowboard" />
        </ul>
      </div>

      <div className="ski-resort-components">
        <h2>Karnety</h2>
        <ul>
          <CIncomeComponents reportId={activeReport.id} itemName="Karnet 1h" />
          <CIncomeComponents reportId={activeReport.id} itemName="Karnet 2h" />
          <CIncomeComponents reportId={activeReport.id} itemName="Karnet 5h" />
          <CIncomeComponents reportId={activeReport.id} itemName="Karnet 24h" />
        </ul>
      </div>
      
      <div className="ski-school-components">
        <h2>Szkółka narciarska</h2>
        <ul>
          <CIncomeComponents reportId={activeReport.id} itemName="Lekcja" />
        </ul>
      </div>

    </div>
  );
}

export default Income;
