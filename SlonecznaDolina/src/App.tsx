import { HashRouter as Router, Routes, Route } from 'react-router-dom'

import CHeader from './components/layout/CHeader'
import Income from './components/pages/Income'
import Reports from './components/pages/Reports'
import Schedule from './components/pages/Schedule'
import Calendar from './components/pages/Calendar'
import Settings from './components/pages/Settings'
import Auth from './components/pages/Auth'
import { ProtectedRoute } from './components/domain/auth/ProtectedRoute'

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
          <Route path="/pages/Income" element={<ProtectedRoute requiredRole="admin"><Income /></ProtectedRoute>} />
          <Route path="/pages/Reports" element={<ProtectedRoute requiredRole="admin"><Reports /></ProtectedRoute>} />
          <Route path="/pages/Schedule" element={<Schedule />} />
          <Route path="/pages/Calendar" element={<Calendar />} />
          <Route path="/pages/Settings" element={<ProtectedRoute requiredRole="admin"><Settings /></ProtectedRoute>} />
          <Route path="/pages/Auth" element={<Auth />} />
        </Routes>
      </Router>
    </AuthProvider>
    </>
  )
}

export default App
