export class SessionService
{
    allSessions:{sessionName:string,description:string,instructorName:string}[] = [];

    addSession(sessionName:string,description:string,instructorName:string)
    {
        this.allSessions.push({sessionName,description,instructorName});
    }
    updateSession(id:number,sessionName:string,description:string,instructorName:string)
    {
        this.allSessions[id].sessionName = sessionName;
        this.allSessions[id].description = description;
        this.allSessions[id].instructorName = instructorName;
    }
    deleteSession(id:number)
    {
        this.allSessions.splice(id,1);
    }

    getSession(id:number)
    {
        return this.allSessions[id];
    }

}