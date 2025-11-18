import { useEffect, useState } from "react";
import "./CIncomeSettingComponents.css";

interface Props {
  settingName: string;
}

function CIncomeSettingComponents({ settingName }: Props) {
  const [setting, setSetting] = useState<number>(0);

  return (
    <div className="setting-item">
      <div className="setting-info">
        <h4>Cena {settingName}: </h4>
      </div>

      <div className="setting-input">
        <input type="number" min={0} />
        <button>Ustaw wartość</button>
      </div>
    </div>
  );
}
export default CIncomeSettingComponents;
