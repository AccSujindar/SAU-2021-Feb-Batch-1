import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SessionService } from 'src/app/sessions.service';

@Component({
  selector: 'app-edit-session',
  templateUrl: './edit-session.component.html',
  styleUrls: ['./edit-session.component.css']
})
export class EditSessionComponent implements OnInit {
  editCurrentId: number;
  editCurrentSession:{sessionName:string,description:string,instructorName:string};
  constructor(private sessionService: SessionService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.editCurrentId = this.route.snapshot.params['id'];
    if(this.editCurrentId < 0 || this.sessionService.allSessions.length===0 || this.editCurrentId >= this.sessionService.allSessions.length)
    {
      this.router.navigate(['/sessions']);
    }
    this.editCurrentSession = this.sessionService.getSession(this.editCurrentId);
  }
  updateSession()
  {
    if(confirm("Are you sure?"))
    {
      this.sessionService.updateSession(this.editCurrentId,this.editCurrentSession.sessionName,this.editCurrentSession.description,this.editCurrentSession.instructorName);
      this.router.navigate(['/sessions/'+this.editCurrentId]);
    }
    
  }
}
