import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GasTypeComponent } from './gas-type.component';

describe('GasTypeComponent', () => {
  let component: GasTypeComponent;
  let fixture: ComponentFixture<GasTypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GasTypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GasTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
