import "./styles.css";
import React, { useState } from "react";
import axios from "axios";

export default function App() {
  const [formData, setFormData] = useState({
    sourceValue: "",
    sourceUnit: "",
    targetUnit: "",
    targetValue: ""
  });

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log(formData);

    axios
      .post("http://ec2-18-191-148-26.us-east-2.compute.amazonaws.com:8080/evaluate", formData)
      .then((response) => {
        document.getElementById('output').innerHTML = '<h2>'+ response.data +'</h2>'
        console.log("Form submitted successfully!", response);
      })
      .catch((error) => {
        console.error("Error submitting form:", error);
      });
  };

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormData((prevFormData) => ({ ...prevFormData, [name]: value }));
  };

  return (
    <>
    <div>
      <h1>Flexion</h1>
    </div>
    <form onSubmit={handleSubmit}>
      <div className="App">
        <div className="input-field">
          <label htmlFor="sourceValue">Input Numerical Value</label>
          <input
            type="number"
            id="sourceValue"
            name="sourceValue"
            value={formData.sourceValue}
            onChange={handleChange}
            required
          />
        </div>

        <div className="input-field">
          <label htmlFor="sourceUnit">Input Unit of Measure</label>
          <input
            type="text"
            id="sourceUnit"
            name="sourceUnit"
            value={formData.sourceUnit}
            onChange={handleChange}
            required
          />
        </div>

        <div className="input-field">
          <label htmlFor="targetUnit">Target Unit of Measure</label>
          <input
            type="text"
            id="targetUnit"
            name="targetUnit"
            value={formData.targetUnit}
            onChange={handleChange}
            required
          />
        </div>

        <div className="input-field">
          <label htmlFor="targetValue">Student Response</label>
          <input
            type="number"
            id="targetValue"
            name="targetValue"
            value={formData.targetValue}
            onChange={handleChange}
            required
          />
        </div>
        <button id="submit-btn" type="submit">
          Submit
        </button>
      </div>
    </form>
    <div>
      <p class="text-center" id="output"></p>
    </div>
    </>
  );
}
