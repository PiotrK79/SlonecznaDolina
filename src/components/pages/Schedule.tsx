import CScheduleWithInstructor from "../domain/schedule/CScheduleWithInstructor"

function Schedule(){

    return(
       <div className="schedule-container">
         <h1>Plan zajęć</h1>
         <CScheduleWithInstructor></CScheduleWithInstructor>
       </div>
        
    )
}export default Schedule