import { TestBed } from '@angular/core/testing';

import { CanActivateAuthInstaService } from './can-activate-auth-insta.service';

describe('CanActivateAuthInstaService', () => {
  let service: CanActivateAuthInstaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CanActivateAuthInstaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
