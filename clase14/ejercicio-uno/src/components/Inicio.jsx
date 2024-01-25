import React from "react";
import logo from "../logo.svg";

const Inicio = (props) => {
  return (
    <div className="home">
      <h1>{props.title}</h1>
      <p>
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Totam velit
        nostrum, quis mollitia vero obcaecati nihil corporis voluptates
        accusantium, consectetur dolores distinctio ab nulla amet reprehenderit,
        aperiam cum quae odio!
      </p>
      <img src={logo} alt="" />
      <footer>
        <p>web created by Lucas</p>
      </footer>
    </div>
  );
};

export default Inicio;
