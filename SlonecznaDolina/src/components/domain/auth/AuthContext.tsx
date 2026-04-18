import React, { createContext, useContext, useEffect, useState } from 'react';
import {jwtDecode} from 'jwt-decode';


interface DecodedToken {
  exp: number;
  iat: number;
  sub: string;
  email: string;
  role: string;
}

interface AuthContextType {
    accessToken: string | null;
    setAccessToken: (token: string | null) => void;
    roles: string[];
}

const AuthContext = createContext<AuthContextType>({
    accessToken: null,
    setAccessToken: () => {},
    roles: []
});

export const AuthProvider = ({ children }: { children: React.ReactNode }) => {
  const [accessToken, setAccessToken] = useState<string | null>(null);
  const [roles, setRoles] = useState<string[]>([]);

  useEffect(() => { 
    if (accessToken) {
      try {
        const decoded = jwtDecode<DecodedToken>(accessToken);
        console.log('Decoded token:', decoded);
        console.log('Role from token:', decoded.role);
        setRoles([decoded.role]);
      } catch (error) {
        console.error('Error decoding access token:', error);
      }
    }else {
        setRoles([]);//Reset roli
    }
  }, [accessToken]);


  return (
    <AuthContext.Provider value={{ accessToken, setAccessToken, roles }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => useContext(AuthContext);