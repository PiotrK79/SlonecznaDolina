import { useState } from "react";
import CScheduleTable from "./CScheduleTable";
import "./CScheduleWithInstructor.css";

interface Report {
  id: string;
  name: string;
  date: string;
}

interface Props {
  activeReport: Report | null;
}

function CScheduleWithInstructor({ activeReport }: Props) {
  const instructors = ["Piotr", "Szymon", "Adam"];
  const [currentInstructor, setCurrentInstructor] = useState("Piotr");

  if (!activeReport) return <div>Ładowanie...</div>;

  return (
    <div className="schedule-with-instructor">
      <div className="instructor-selection">
        <h2>Plan instruktora:</h2>
        <select
          value={currentInstructor}
          onChange={(e) => setCurrentInstructor(e.target.value)}
        >
          {instructors.map((instr) => (
            <option key={instr} value={instr}>
              {instr}
            </option>
          ))}
        </select>
      </div>

      <CScheduleTable
        key={`${activeReport.id}_${currentInstructor}`}
        instructor={currentInstructor}
        reportId={activeReport.id}
      />
    </div>
  );
}

export default CScheduleWithInstructor;
