// import { useState } from "react";
import CIncomeComponents from "../domain/CIncomeComponents";

function Income(){


    return(
        <>  
            <h1>Przychód</h1>
            <div className="rental-office">
                <h2>Wypożyczalnia</h2>
                <div className="rental-office-components">
                    <ul>
                        <CIncomeComponents itemName="Narty" amount = {0}/>
                        <CIncomeComponents itemName="Buty" amount = {0}/>
                        <CIncomeComponents itemName="Kijki" amount = {0}/>
                        <CIncomeComponents itemName="Snowboard" amount = {0}/>
                    </ul>
                </div>
            </div>
            <div className="ski-resort-components">
                <h2>Ośrodek narciarski</h2>
                <ul>
                    <CIncomeComponents itemName="Lekcja" amount = {0}/>
                    <CIncomeComponents itemName="Karnet" amount = {0}/>
                </ul>
            </div>
        </>
    )
}export default Income