import { HashRouter as Router, Routes, Route } from 'react-router-dom'

import CHeader from './components/layout/CHeader'
import Income from './components/pages/Income'
import Reports from './components/pages/Reports'
import Schedule from './components/pages/Schedule'
import Calendar from './components/pages/Calendar'
import Settings from './components/pages/Settings'
import Auth from './components/pages/Auth'

import './App.css'
import { AuthProvider } from './components/domain/auth/AuthContext'

function App() {

  return (
    <>
    <AuthProvider>
      <Router>
        <CHeader/>
        <Routes>
          {/* <Route path="/" element={<CHeader />} /> */}
          <Route path="/pages/Income" element={<Income />} />
          <Route path="/pages/Reports" element={<Reports />} />
          <Route path="/pages/Schedule" element={<Schedule />} />
          <Route path="/pages/Calendar" element={<Calendar />} />
          <Route path="/pages/Settings" element={<Settings />} />
          <Route path="/pages/Auth" element={<Auth />} />
        </Routes>
      </Router>
    </AuthProvider>
    </>
  )
}

export default App
