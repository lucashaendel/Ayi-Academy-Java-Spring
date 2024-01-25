import logo from "./logo.svg";
import spring from "./spring.svg";
import "./App.css";

function App() {
  return (
    <div>
      <h1>Curso de Java, Spring Boot y React.</h1>
      <div className="container-imagenes">
        <div className="img-spring">
          <h2>Imagen desde Spring Boot</h2>
          <img src={spring} alt="" />
        </div>
        <div className="img-react">
          <h2>Imagen desde React</h2>
          <img src={logo} alt="" />
        </div>
      </div>
    </div>
  );
}

export default App;
