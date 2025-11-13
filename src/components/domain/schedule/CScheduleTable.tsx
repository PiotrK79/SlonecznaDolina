import { useState, useEffect } from "react";
import "./CscheduleTable.css";

interface Props {
  instructor: string;
}

function CScheduleTable({ instructor }: Props) {
  const days = ["Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela"];
  const hours = Array.from({ length: 12 }, (_, i) => `${8 + i}:00`);

  // Oddzielny klucz w localStorage dla każdego instruktora
  const [schedule, setSchedule] = useState<Record<string, string>>({});

  // Ładowanie danych przy zmianie instruktora
  useEffect(() => {
    const saved = localStorage.getItem(`schedule_${instructor}`);
    setSchedule(saved ? JSON.parse(saved) : {});
  }, [instructor]);

  // Zapisywanie do localStorage po zmianie planu
  useEffect(() => {
    localStorage.setItem(`schedule_${instructor}`, JSON.stringify(schedule));
  }, [schedule, instructor]);

  // Aktualizacja konkretnej komórki
  const updateCell = (day: string, hour: string, value: string) => {
    setSchedule((prev) => ({
      ...prev,
      [`${day}-${hour}`]: value,
    }));
  };

  return (
    <div>
      {/* <h3>Plan instruktora: {instructor}</h3> */}
      <table className="schedule-table">
        <thead>
          <tr>
            <th>Godzina</th>
            {days.map((day) => (
              <th key={day}>{day}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {hours.map((hour) => (
            <tr key={hour}>
              <td className="hour-cell">{hour}</td>
              {days.map((day) => {
                const key = `${day}-${hour}`;
                return (
                  <td key={key} className="lesson-cell">
                    <input
                      type="text"
                      value={schedule[key] || ""}
                      onChange={(e) => updateCell(day, hour, e.target.value)}
                    />
                  </td>
                );
              })}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default CScheduleTable;
