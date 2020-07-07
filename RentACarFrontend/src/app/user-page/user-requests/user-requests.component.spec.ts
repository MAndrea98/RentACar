import { UserRequestComponent } from "./user-requests.component";
import { ComponentFixture, TestBed, async } from '@angular/core/testing';

describe('UserRequestComponent', () => {
    let component: UserRequestComponent;
    let fixture: ComponentFixture<UserRequestComponent>;
  
    beforeEach(async(() => {
      TestBed.configureTestingModule({
        declarations: [ UserRequestComponent ]
      })
      .compileComponents();
    }));
  
    beforeEach(() => {
      fixture = TestBed.createComponent(UserRequestComponent);
      component = fixture.componentInstance;
      fixture.detectChanges();
    });
  
    it('should create', () => {
      expect(component).toBeTruthy();
    });
});