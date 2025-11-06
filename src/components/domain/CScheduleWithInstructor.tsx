import { useState } from "react";
import CScheduleTable from "./CScheduleTable";

function CScheduleWithInstructor() {
  const instructors = ["Piotr", "Szymon", "Adam"];
  const [currentInstructor, setCurrentInstructor] = useState("Piotr");

  return (                    // <-- MUSI BYĆ RETURN!
    <div>
      <h2>Wybierz instruktora</h2>

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

      {/* Przekazujemy wybranego instruktora do tabeli */}
      <CScheduleTable instructor={currentInstructor} />
    </div>
  );
}

export default CScheduleWithInstructor;
