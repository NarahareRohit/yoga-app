import './App.css';
import * as React from 'react';
import RegistrationForm from "./Component/RegistrationForm";
import { Routes, Route } from 'react-router-dom';
import PaymentCompleted from './Component/PaymentCompleted';
import Admin from './Component/Admin';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Routes>
          <Route path="/" element={<RegistrationForm />} ></Route>
          <Route path='/completedPayment' element={<PaymentCompleted />}></Route>
          <Route path='/admin' element={<Admin />}></Route>
        </Routes>
      </header>
    </div>
  );
}

export default App;
