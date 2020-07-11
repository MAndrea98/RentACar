import { AllRequestsComponent } from "./all-requests.component";
import { ComponentFixture, async, TestBed } from '@angular/core/testing';

describe('AllRequestsComponent', () => {
    let component: AllRequestsComponent;
    let fixture: ComponentFixture<AllRequestsComponent>;
  
    beforeEach(async(() => {
      TestBed.configureTestingModule({
        declarations: [ AllRequestsComponent ]
      })
      .compileComponents();
    }));
  
    beforeEach(() => {
      fixture = TestBed.createComponent(AllRequestsComponent);
      component = fixture.componentInstance;
      fixture.detectChanges();
    });
  
    it('should create', () => {
      expect(component).toBeTruthy();
    });
});