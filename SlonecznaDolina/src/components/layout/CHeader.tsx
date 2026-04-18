import { useNavigate, useLocation } from "react-router-dom";
import { useAuth } from "../domain/auth/AuthContext";
import "./CHeader.css";

export default function CHeader() {
  const navigate = useNavigate();
  const location = useLocation();
  const { roles } = useAuth();

  const isAdmin = roles && Array.isArray(roles) ? roles.some(role => role.toLowerCase() === 'admin') : false;

  return (
    <div className="topbar">
      <div className="title-row">
        <h1 className="main-header">Słoneczna Dolina</h1>
        <p>roles: {roles?.join(', ')}, isAdmin: {isAdmin.toString()}, accessToken: {useAuth().accessToken}</p>
      </div>
      <div className="tabs-row">
        <nav>
          <ul className="router-ul">
            {isAdmin && (
              <li>
                <button
                  className={location.pathname === "/pages/Income" ? "active" : ""}
                  onClick={() => navigate("/pages/Income")}
                >
                  Przychody
                </button>
              </li>
            )}

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
            {isAdmin && (
              <li>
                <button
                  className={location.pathname === "/pages/Reports" ? "active" : ""}
                  onClick={() => navigate("/pages/Reports")}
                >
                  Raporty
                </button>
              </li>
            )}
            {isAdmin && (
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
            )}
            <li>
              <button
                className={location.pathname === "/pages/Auth" ? "active" : ""}
                onClick={() => navigate("/pages/Auth")}
              >
                Zaloguj się
              </button>
            </li>
          </ul>
        </nav>
      </div>
    </div>
  );
}
