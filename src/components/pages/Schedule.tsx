import { useEffect, useState } from "react";
import CScheduleWithInstructor from "../domain/schedule/CScheduleWithInstructor";

interface Report {
  id: string;
  name: string;
  date: string;
}

function Schedule() {
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
    return <h2>Najpierw stwórz raport w zakładce Raporty.</h2>;
  }

  return (
    <div className="schedule-container">
      <CScheduleWithInstructor activeReport={activeReport} />
    </div>
  );
}

export default Schedule;
