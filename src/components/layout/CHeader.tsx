// components/layout/CHeader.tsx
import { NavLink } from 'react-router-dom'
import './CHeader.css'

export default function CHeader() {
  return (
    <div className="topbar">
      <h1 className='main-header'>Słoneczna Dolina</h1>
      <nav>
        <ul className='router-ul'>
          <li><NavLink to="/pages/Income" className={({isActive}) => isActive ? 'active' : ''}>Przychody</NavLink></li>
          <li><NavLink to="/pages/Raports" className={({isActive}) => isActive ? 'active' : ''}>Raporty</NavLink></li>
          <li><NavLink to="/pages/Schedule" className={({isActive}) => isActive ? 'active' : ''}>Plan zajęć</NavLink></li>
          {/* <li><NavLink to="/pages/Calendar" className={({isActive}) => isActive ? 'active' : ''}>Kalendarz</NavLink></li> */}
          <li><NavLink to="/pages/Settings" className={({isActive}) => isActive ? 'active' : ''}>Ustawienia</NavLink></li>
        </ul>
      </nav>
    </div>
  )
}
