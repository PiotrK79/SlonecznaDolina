import CIncomeComponents from "../domain/CIncomeComponents";

function Income(){

    return(
        <>  
            <h1>Przychód</h1>
            <div className="rental-office">
                <h2>Wypożyczalnia</h2>
                <div className="rental-office-components">
                    <ul>
                        <CIncomeComponents name="Narty"/>
                        <CIncomeComponents name="Buty"/>
                        <CIncomeComponents name="Kijki"/>
                        <CIncomeComponents name="Snowboard"/>
                    </ul>
                </div>
            </div>
            <div className="ski-resort-components">
                <h2>Ośrodek narciarski</h2>
                <ul>
                    <CIncomeComponents name="Godzina lekcji"/>
                    <CIncomeComponents name="Karnet"/>
                </ul>
            </div>
        </>
    )
}export default Income