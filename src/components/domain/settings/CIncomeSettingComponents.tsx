import { useEffect, useState } from "react";
import "./CIncomeSettingComponents.css";

interface Props {
  settingName: string;
}

function CIncomeSettingComponents({ settingName }: Props) {
  const storageKey = `setting_${settingName}`;
  const [setting, setSetting] = useState<number>(0);
  const [inputValue, setInputValue] = useState("");

  useEffect(() => {

    const saved = localStorage.getItem(storageKey);

    if (saved) {
      setSetting(Number(saved));
      setInputValue(saved);
    }
  }, [storageKey]);

  const handleSave = () => {
    localStorage.setItem(storageKey, inputValue);

    setSetting(Number(inputValue));
  };

  return (
    <div className="setting-item">
      <div className="setting-info">
        <h4>Cena {settingName}: {setting}zł</h4>
      </div>

      <div className="setting-input">
        <input
          type="number"
          min={0}
          value={inputValue}
          onChange={(e) => {
            setInputValue(e.target.value);
          }}
        />
        <button onClick={handleSave}>Ustaw wartość</button>
      </div>
    </div>
  );
}

export default CIncomeSettingComponents;
