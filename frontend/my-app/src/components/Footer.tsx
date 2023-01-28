import github from "../img/GitHub.png";


export const Footer = () => {
  return (
    <div className="footer-container">
    <section >
        <a href="https://github.com/icheng3/hack-at-brown-23" target="_blank" rel="noreferrer">
                <img className = "github-logo" src={github} alt="GitHub logo"></img>
                {/* <img src={require(github)} /> */}
              </a>

    </section>
    </div>
  );
};