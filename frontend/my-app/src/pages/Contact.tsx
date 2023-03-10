import React, { useState } from "react";
import { Container, Form, Button, Alert, Row, Col } from "react-bootstrap";

export const Contact = () => {
  const [name, setName] = useState<string>("");
  const [email, setEmail] = useState<string>("");
  const [message, setMessage] = useState<string>("");
  const [show, setShow] = useState<boolean>(false);

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    if (name === "name") {
      setName(value);
    } else if (name === "email") {
      setEmail(value);
    } else if (name === "message") {
      setMessage(value);
    }
  };

  return (
    
      <Container className="contact-form-container">
        
        <Form.Floating>
          <h1>Contact Us</h1>
          <Form.Group>
            <Form.Label>Name</Form.Label>
            <Form.Control
              type="text"
              name="name"
              placeholder="Enter your name"
              value={name}
              onChange={handleChange}
            />
          </Form.Group>
          <Form.Group>
            <Form.Label>Email</Form.Label>
            <Form.Control
              type="email"
              name="email"
              placeholder="Enter your email"
              value={email}
              onChange={handleChange}
              required
            />
          </Form.Group>
          <Form.Group>
            <Form.Label>Message</Form.Label>
            <Form.Control
              as="textarea"
              placeholder="Enter your message"
              value={message}
              name="message"
              onChange={handleChange}
            />
          </Form.Group>
          <Button variant="primary" type="submit" onClick={() => setShow(true)}>
            Submit
          </Button>
        </Form.Floating>
        <Alert show={show} variant="success">
          Your message has been sent!
        </Alert>
      </Container>
    
  );
};

export default Contact;