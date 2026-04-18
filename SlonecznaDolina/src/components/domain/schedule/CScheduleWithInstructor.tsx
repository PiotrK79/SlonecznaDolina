import { useState, useEffect } from "react";
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
  const [instructors, setInstructors] = useState<string[]>([]);
  const [currentInstructor, setCurrentInstructor] = useState<string>("");

  useEffect(() => {
    console.log("[Schedule] Loading instructors from LS...");

    const saved = localStorage.getItem("instructors");
    const list = saved ? JSON.parse(saved) : [];

    console.log("[Schedule] Loaded instructors:", list);

    setInstructors(list);

    if (list.length > 0) {
      setCurrentInstructor(list[0]);
    } else {
      setCurrentInstructor("");
    }
  }, []);

  if (!activeReport) return <div>Ładowanie...</div>;

  return (
    <div className="schedule-with-instructor">
      <div className="instructor-selection">
        <h2>Plan instruktora:</h2>

        {instructors.length === 0 ? (
          <p style={{ color: "red" }}>Brak instruktorów — dodaj ich w ustawieniach.</p>
        ) : (
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
        )}
      </div>

      {currentInstructor && (
        <CScheduleTable
          key={`${activeReport.id}_${currentInstructor}`}
          instructor={currentInstructor}
          reportId={activeReport.id}
        />
      )}
    </div>
  );
}

export default CScheduleWithInstructor;
