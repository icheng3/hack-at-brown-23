
import React from 'react';
import { GoogleMap, LoadScript, Marker } from '@react-google-maps/api';
import key from "../private/key"
import { locations } from '../mocks/locations';
import { Col, Container, Row } from 'react-bootstrap';

const MapContainer = () => {
  
  const mapStyles = {        
    height: "100vh",
    width: "100%"};
  
  const defaultCenter = {
    lat: 41.825226, lng: -71.4774
  }
  
  
  return (
     <LoadScript
       googleMapsApiKey={key}>
        <GoogleMap
          mapContainerStyle={mapStyles}
          zoom={13}
          center={defaultCenter}>
{/* 
         {
            locations.map(item => {
              return (
              <Marker key={item.name} position={item.location}/>
              )
            })
         } */}
     </GoogleMap>
     </LoadScript>
  )
}

function WeatherArea(){
    return (
        <>
            <div className="card" >
            <section className="section dark">
            <h5 className="strong">
                <strong>Temperature: {}</strong>
            </h5>
            <p>Rainfall : {}</p>
            </section>
            </div>
        </>
    )
}

function CampsiteArea(){
    return (
        <>
            <div className="card" >
            <section className="section dark">
            <h5 className="strong">
                <strong>Campsite Name: {}</strong>
            </h5>
            <p>Location : {}</p>
            </section>
            </div>
        </>
    )
}


function InformationArea(){
    return (
        <>
        <Container>
        <Row>
            <Col>
            <WeatherArea />
            </Col>
            <Col>
            <CampsiteArea />
            </Col>
        </Row>
         </Container >  
        </>
    )
}

function Map(){
    return(
        <>
    <h2>Map</h2>
    <div className='Map-Area'>
         <MapContainer /> 
        <InformationArea />
    </div>
        </>
    ) 
}


export default Map;