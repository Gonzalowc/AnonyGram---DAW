import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MensajePropioComponent } from './mensaje-propio.component';

describe('MensajePropioComponent', () => {
  let component: MensajePropioComponent;
  let fixture: ComponentFixture<MensajePropioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MensajePropioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MensajePropioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
