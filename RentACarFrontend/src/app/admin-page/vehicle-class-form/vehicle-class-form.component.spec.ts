import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleClassFormComponent } from './vehicle-class-form.component';

describe('VehicleClassFormComponent', () => {
  let component: VehicleClassFormComponent;
  let fixture: ComponentFixture<VehicleClassFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VehicleClassFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VehicleClassFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
