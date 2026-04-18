import { useState } from 'react';
import './Auth.css';
import { useAuth } from '../domain/auth/AuthContext';

export default function Auth() {
  const { accessToken, setAccessToken } = useAuth();
  const [isLogin, setIsLogin] = useState(true);
  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: ''
  });
  const [message, setMessage] = useState('');

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setMessage('');

    const endpoint = isLogin ? 'http://localhost:8080/auth/login' : 'http://localhost:8080/auth/register';
    const body = isLogin
      ? { email: formData.email, password: formData.password }
      : { name: formData.username, email: formData.email, password: formData.password };

    try {
      const response = await fetch(endpoint, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
      });

      if (response.ok) {
        const data = await response.json();
        if(isLogin) {
            setMessage(`Welcome back! Your token: ${data.token}`);
            setAccessToken(data.token);
        }else {
            setMessage(`Registration successful! Welcome, ${data.name}!}`);
            setIsLogin(true);
            setFormData(prevData => ({ ...prevData, password: '' }));
        }
                
      } else {
        const error = await response.text();
        setMessage(`Error: ${error}`);
      }
    } catch (error) {
      setMessage('Network error. Please try again.');
    }
  };

  return (
    <div className="auth-container">
      <div className="auth-form">
        <h2>{isLogin ? 'Zaloguj się' : 'Zarejestruj się'}</h2>
        <form onSubmit={handleSubmit}>
          {!isLogin && (
            <div className="form-group">
              <label htmlFor="username">Nazwa użytkownika</label>
              <input
                type="text"
                id="username"
                name="username"
                value={formData.username}
                onChange={handleChange}
                required={!isLogin}
              />
            </div>
          )}
          <div className="form-group">
            <label htmlFor="email">Email</label>
            <input
              type="email"
              id="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="password">Hasło</label>
            <input
              type="password"
              id="password"
              name="password"
              value={formData.password}
              onChange={handleChange}
              required
            />
          </div>
          <button type="submit" className="auth-button">
            {isLogin ? 'Zaloguj się' : 'Zarejestruj się'}
          </button>
        </form>
        <button
          type="button"
          className="toggle-button"
          onClick={() => setIsLogin(!isLogin)}
        >
          {isLogin ? 'Nie masz konta? Zarejestruj się' : 'Masz konto? Zaloguj się'}
        </button>
        {message && <p className="message">{message}</p>}
      </div>
    </div>
  );
}