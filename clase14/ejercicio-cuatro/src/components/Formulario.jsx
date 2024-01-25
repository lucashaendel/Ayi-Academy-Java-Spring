import React, { useState } from "react";

const Formulario = (props) => {
  const [numClient, setNumClient] = useState(0);
  const [name, setName] = useState("");
  const [lastName, setLastName] = useState("");
  const [typeClient, setTypeClient] = useState(true);

  const handleChange = (e) => {
    if (e.target.name === "number") {
      setNumClient(e.target.value);
    } else if (e.target.name === "name") {
      setName(e.target.value);
    } else if (e.target.name === "lastName") {
      setLastName(e.target.value);
    } else if (e.target.name === "typeClient") {
      setTypeClient(e.target.value);
    }
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(numClient);
    console.log(name);
    console.log(lastName);
    console.log(typeClient);
  };

  return (
    <div>
      <h1>{props.title}</h1>
      <form action="form" onSubmit={handleSubmit}>
        <input type="number" name="number" onChange={handleChange} />
        <input type="text" name="name" onChange={handleChange} />
        <input type="text" name="lastName" onChange={handleChange} />
        <input type="number" name="typeClient" onChange={handleChange} />
        <input type="submit" value="submit" />
      </form>
      <h2>{props.subTitle}</h2>
    </div>
  );
};

export default Formulario;
