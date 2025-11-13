// import { useState } from "react";
import CIncomeComponents from "../domain/income/CIncomeComponents";
import "./Income.css";

function Income() {
  return (
    <>
      <div className="income-menu">
        <div className="rental-office">
          <h2>Wypożyczalnia</h2>
          <div className="rental-office-components">
            <ul>
              <CIncomeComponents itemName="Narty" amount={0} />
              <CIncomeComponents itemName="Buty" amount={0} />
              <CIncomeComponents itemName="Kijki" amount={0} />
              <CIncomeComponents itemName="Snowboard" amount={0} />
            </ul>
          </div>
        </div>
        <div className="ski-resort-components">
          <h2>Ośrodek narciarski</h2>
          <ul>
            <CIncomeComponents itemName="Lekcja" amount={0} />
            <CIncomeComponents itemName="Karnety" amount={0} />
          </ul>
        </div>
      </div>
    </>
  );
}
export default Income;
