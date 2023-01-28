import React from 'react';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from "./pages/Home";
import Map from "./pages/Map";
import Contact from "./pages/Contact";
import { NavBar } from './components/NavBar';


function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <NavBar />
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/map" element={<Map/>} />
        <Route path="/contact" element={<Contact/>} />
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
