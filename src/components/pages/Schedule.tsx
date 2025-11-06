import CScheduleWithInstructor from "../domain/CScheduleWithInstructor"

function Schedule(){

    return(
       <div className="schedule-container">
         <h1>Plan zajęć</h1>
         <CScheduleWithInstructor></CScheduleWithInstructor>
       </div>
        
    )
}export default Schedule