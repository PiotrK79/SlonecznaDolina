import { ReactNode } from 'react';
import { useAuth } from './AuthContext';

interface ProtectedRouteProps {
  children: ReactNode;
  requiredRole?: string;
}

export const ProtectedRoute = ({ children, requiredRole }: ProtectedRouteProps) => {
  const { roles } = useAuth();

  if (requiredRole && !roles.some(role => role.toLowerCase() === requiredRole.toLowerCase())) {
    return <div className="unauthorized">Brak dostępu. Wymagana rola: {requiredRole}</div>;
  }

  return <>{children}</>;
};