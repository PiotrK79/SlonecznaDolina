import { useNavigate, useLocation } from "react-router-dom";
import "./CHeader.css";

export default function CHeader() {
  const navigate = useNavigate();
  const location = useLocation();

  return (
    <div className="topbar">
      <h1 className="main-header">Słoneczna Dolina</h1>
      <nav>
        <ul className="router-ul">
          <li>
            <button
              className={location.pathname === "/pages/Income" ? "active" : ""}
              onClick={() => navigate("/pages/Income")}
            >
              Przychody
            </button>
          </li>

          <li>
            <button
              className={
                location.pathname === "/pages/Schedule" ? "active" : ""
              }
              onClick={() => navigate("/pages/Schedule")}
            >
              Plan zajęć
            </button>
          </li>
          <li>
            <button
              className={location.pathname === "/pages/Raports" ? "active" : ""}
              onClick={() => navigate("/pages/Raports")}
            >
              Raporty
            </button>
          </li>
          <li>
            <button
              className={
                location.pathname === "/pages/Settings" ? "active" : ""
              }
              onClick={() => navigate("/pages/Settings")}
            >
              Ustawienia
            </button>
          </li>
        </ul>
      </nav>
    </div>
  );
}
