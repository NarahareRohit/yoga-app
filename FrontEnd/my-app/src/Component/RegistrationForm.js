import React, { useState } from 'react';
import axios from 'axios';
// import { useHistory } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';


import './app.css';

const RegistrationForm = () => {
  // const history = useHistory();
  const navigate  = useNavigate();
  const [formData, setFormData] = useState({
    name: '',
    age: '',
    email: '',
    batch: '',
    paymentStatus: 'COD', // Default value
  });

  const [errors, setErrors] = useState({});
  const [successMessage, setSuccessMessage] = useState('');

  const validateForm = () => {
    const newErrors = {};

    // Validate age (between 18 and 65)
    if (formData.age < 18 || formData.age > 65) {
      newErrors.age = 'Age must be between 18 and 65';
    }

    // Validate email format
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(formData.email)) {
      newErrors.email = 'Invalid email format';
    }

    setErrors(newErrors);

    // Return true if there are no errors
    return Object.keys(newErrors).length === 0;
  };

  const handleInputChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!validateForm()) {
      // If validation fails, return early
      return;
    }

    try {
      // Make Axios call to backend API
      const response = await axios.post('https://backend-yoga-production.up.railway.app/user/add', formData);
      console.log(response.data);
      setSuccessMessage(response.data.message);
      if (formData.paymentStatus === 'Online') {
        // Redirect to the next page for online payment completion
        // history.push('/payment-completed');
        navigate("/completedPayment")
      } else {
        // Display a thank you message for COD payment
        alert('Response Submitted');
        setFormData({
          name: '',
          age: '',
          email: '',
          batch: '',
          paymentStatus: 'Offline'
        });
      }

    } catch (error) {
      // Handle API call error
      console.error('Error submitting registration:', error);
    }
  };

  return (
    <div>
      <h2>Yoga Classes Registration</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="name">Name:</label>
          <input type="text" id="name" name="name" value={formData.name} onChange={handleInputChange} required />
        </div>
        <div>
          <label htmlFor="age">Age:</label>
          <input type="number" id="age" name="age" value={formData.age} onChange={handleInputChange} required />
          {errors.age && <p className="error">{errors.age}</p>}
        </div>
        <div>
          <label htmlFor="email">Email:</label>
          <input type="email" id="email" name="email" value={formData.email} onChange={handleInputChange} required />
          {errors.email && <p className="error">{errors.email}</p>}
        </div>
        <div>
          <label htmlFor="batch">Batch:</label>
          <select id="batch" name="batch" value={formData.batch} onChange={handleInputChange} required>
            <option value="">Select Batch</option>
            <option value="1">B1</option>
            <option value="2">B2</option>
            <option value="3">B3</option>
            <option value="4">B4</option>
          </select>
        </div>
        <div>
          <div className='p'>500 Rs/month</div>
          <label>
            Payment Mode:
            <input type="radio" name="paymentStatus" value="Online" checked={formData.paymentStatus === 'Online'} onChange={handleInputChange} />
            Online
          </label>
          <label>
            <input type="radio"   name="paymentStatus" value="oflline" checked={formData.paymentStatus === 'Offline'} onChange={handleInputChange} />
            Offline
          </label>
        </div>
        <button type="submit">Register</button>
      </form>
      {successMessage && <p className="success">{successMessage}</p>}
    </div>
  );
};

export default RegistrationForm;
