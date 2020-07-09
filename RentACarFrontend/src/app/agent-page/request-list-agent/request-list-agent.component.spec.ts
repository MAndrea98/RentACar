import { RequestListAgentComponent } from "./request-list-agent.component";
import { ComponentFixture, TestBed, async } from '@angular/core/testing';

describe('RequestListAgentComponent', () => {
    let component: RequestListAgentComponent;
    let fixture: ComponentFixture<RequestListAgentComponent>;
  
    beforeEach(async(() => {
      TestBed.configureTestingModule({
        declarations: [ RequestListAgentComponent ]
      })
      .compileComponents();
    }));
  
    beforeEach(() => {
      fixture = TestBed.createComponent(RequestListAgentComponent);
      component = fixture.componentInstance;
      fixture.detectChanges();
    });
  
    it('should create', () => {
      expect(component).toBeTruthy();
    });
});