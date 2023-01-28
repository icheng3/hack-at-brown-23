import React from "react";
import { Row, Image } from "react-bootstrap";
import twitter from "../img/twitter.png";
import github from "../img/github.png";
import linkedin from "../img/linkedin.png";

export const Footer = () => {
  return (
    <div className="footer-container">
      <Row className="social-media">
        <ul>
          <li>
            <a href="www.Github.com">
              {/* <Image src={github} /> */}
            </a>
          </li>
        </ul>
      </Row>
    </div>
  );
};