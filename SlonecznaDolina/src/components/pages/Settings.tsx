import CIncomeSettingComponents from "../domain/settings/CIncomeSettingComponents";
import CInstructorSettingComponent from "../domain/settings/CInstructorSettingComponent";
import "./Settings.css";

function Settings() {
  return (
    <div className="settings-menu">
      <div className="rental-settings">
        <h2>Wypożyczalnia</h2>
        <div className="components-section">
          <CIncomeSettingComponents settingName="Nart"></CIncomeSettingComponents>
          <CIncomeSettingComponents settingName="Butów"></CIncomeSettingComponents>
          <CIncomeSettingComponents settingName="Kijków"></CIncomeSettingComponents>
          <CIncomeSettingComponents settingName="Snowboardu"></CIncomeSettingComponents>
        </div>
      </div>

      <div className="resort-settings">
        <h2>Karnety</h2>
        <div className="components-section">
          <CIncomeSettingComponents settingName="Karnetu 1h"></CIncomeSettingComponents>
          <CIncomeSettingComponents settingName="Karnetu 2h"></CIncomeSettingComponents>
          <CIncomeSettingComponents settingName="Karnetu 5h"></CIncomeSettingComponents>
          <CIncomeSettingComponents settingName="Karnetu 24h"></CIncomeSettingComponents>
        </div>
      </div>

      <div className="school-settings">
        <h2>Szkółka narciarska</h2>
        <CIncomeSettingComponents settingName="Godziny lekcji"></CIncomeSettingComponents>
      </div>

      <div className="instructor-settings">
        <br />
        <h2>Instruktorzy</h2>
        <CInstructorSettingComponent></CInstructorSettingComponent>
      </div>

    </div>
  );
}
export default Settings;
