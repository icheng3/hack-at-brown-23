import React from "react";
import { Navbar, Container, Nav } from "react-bootstrap";
import { Link } from "react-router-dom";

/*
Navigation bar (for router to go between pages)
*/

export const NavBar = () => {
  return (
    <Navbar sticky="top"  expand="md">
      <Container>
        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
        <Navbar.Collapse id="responsive-navbar-nav">
          <Nav>
          <div className="container">
          <div className="row">
            <Link to="/">Home</Link>
            <Link to="/map">Map</Link>
            <Link to="/contact">Contact</Link> 
          </div>
          </div>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};