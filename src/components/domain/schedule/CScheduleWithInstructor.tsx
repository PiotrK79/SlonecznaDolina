import { useState } from "react";
import CScheduleTable from "./CScheduleTable";
import "./CScheduleWithInstructor.css"



function CScheduleWithInstructor() {
  const instructors = ["Piotr", "Szymon", "Adam"];
  const [currentInstructor, setCurrentInstructor] = useState("Piotr");

  return (                   
    <div>
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
      <CScheduleTable instructor={currentInstructor} />
    </div>
  );
}

export default CScheduleWithInstructor;
