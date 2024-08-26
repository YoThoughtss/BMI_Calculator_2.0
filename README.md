This is a Version 2 of the BMI Checker and I put some minor changes in the app

This is an Android application that calculates the Body Mass Index (BMI) based on user input for weight and height. The application allows users to select units for both weight and height, perform the BMI calculation, and display the corresponding BMI category (Underweight, Normal, Overweight, or Obese).

## Features

- **User-friendly Interface:** Enter weight and height using input fields and select their corresponding units using dropdown menus.
- **Unit Conversion:** Supports multiple units for both weight and height:
  - **Weight Units:** Kilograms, Pounds
  - **Height Units:** Meters, Centimeters, Feet, Inches
- **BMI Calculation:** Computes BMI based on the standard formula:
  BMI = weight * (height * height)
- **BMI Categories:**
  - **Underweight:** BMI < 18.5
  - **Normal:** BMI between 18.5 and 24.9
  - **Overweight:** BMI between 25 and 29.9
  - **Obese:** BMI ≥ 30
- **Result Display:** Shows the calculated BMI value along with the BMI category.

## Getting Started

### Prerequisites

- **Android Studio:** Ensure that you have [Android Studio](https://developer.android.com/studio) installed on your machine.
- **Gradle:** The project uses Gradle as the build system.

### Installation

1. Clone this repository to your local machine:
    ```bash
    git clone https://github.com/YoThoughtss/BMI_Checker.git
    ```
   
2. Open the project in Android Studio:
    - Go to `File > Open`, and select the cloned project.

3. Build and run the app:
    - Click the "Run" button in Android Studio to compile and launch the app in the emulator or on a physical device.

### Usage

1. **Enter Weight:**
   - Input your weight in the provided field and select the appropriate unit (Kilograms or Pounds) from the dropdown menu.

2. **Enter Height:**
   - Input your height and select the appropriate unit (Meters, Centimeters, Feet, or Inches) from the dropdown menu.

3. **Calculate BMI:**
   - Click on the "Calculate BMI" button to compute your BMI and display the result along with the corresponding BMI category.
  
## Acknowledgements

- Developed by: **Jayvee Somido**
