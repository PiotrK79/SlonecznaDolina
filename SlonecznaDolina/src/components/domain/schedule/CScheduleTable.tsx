import { useState, useEffect } from "react";
import "./CscheduleTable.css";

interface Props {
  instructor: string;
  reportId: string;
}

function CScheduleTable({ instructor, reportId }: Props) {
  const days = ["Poniedziałek","Wtorek","Środa","Czwartek","Piątek","Sobota","Niedziela"];
  const hours = Array.from({ length: 12 }, (_, i) => `${8 + i}:00`);

  const [schedule, setSchedule] = useState<Record<string, string>>({});
  const [loaded, setLoaded] = useState(false);

  useEffect(() => {
    const saved = localStorage.getItem(`schedule_${reportId}_${instructor}`);
    setSchedule(saved ? JSON.parse(saved) : {});
    setLoaded(true);
  }, [reportId, instructor]);

  useEffect(() => {
    if (!loaded) return;
    localStorage.setItem(`schedule_${reportId}_${instructor}`, JSON.stringify(schedule));
  }, [schedule, reportId, instructor, loaded]);

  const updateCell = (day: string, hour: string, value: string) => {
    setSchedule(prev => ({
      ...prev,
      [`${day}-${hour}`]: value
    }));
  };

  return (
    <div>
      <table className="schedule-table">
        <thead>
          <tr>
            <th>Godzina</th>
            {days.map(day => <th key={day}>{day}</th>)}
          </tr>
        </thead>
        <tbody>
          {hours.map(hour => (
            <tr key={hour}>
              <td className="hour-cell">{hour}</td>
              {days.map(day => {
                const key = `${day}-${hour}`;
                return (
                  <td key={key} className="lesson-cell">
                    <input
                      type="text"
                      value={schedule[key] || ""}
                      onChange={e => updateCell(day, hour, e.target.value)}
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
