import { useState, useEffect } from "react";

function CInstructorSettingComponent() {
  const [instructors, setInstructors] = useState<string[]>([]);
  const [newInstructor, setNewInstructor] = useState("");

  useEffect(() => {
    const saved = localStorage.getItem("instructors");
    if (saved) {
      setInstructors(JSON.parse(saved));
    }
  }, []);

  useEffect(() => {
    localStorage.setItem("instructors", JSON.stringify(instructors));
  }, [instructors]);

  const addInstructor = () => {
    const name = newInstructor.trim();
    if (!name) return;
    if (instructors.includes(name)) return;

    setInstructors([...instructors, name]);
    setNewInstructor("");
  };

  const removeInstructor = (name: string) => {
    setInstructors(instructors.filter((inst) => inst !== name));
  };

  return (
    <div className="instructor-settings-menu">
      <div className="add-instructor-form">
        <input
          type="text"
          value={newInstructor}
          placeholder="Dodaj instruktora"
          onChange={(e) => setNewInstructor(e.target.value)}
        />
        <button onClick={addInstructor}>Dodaj</button>
      </div>
      <ul className="instructor-list">
        {instructors.map((inst) => (
          <li key={inst}>
            {inst}
            <button
              className="remove-button"
              onClick={() => removeInstructor(inst)}
            >
                Usuń
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}
export default CInstructorSettingComponent;
