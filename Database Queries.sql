--1. View Player Stats (Defensive back)
SELECT db_name, db_team, db_tackles, db_intcaught
    FROM defensiveback
    GROUP BY db_name;
	
--2. View Player Stats (Linebackers)
SELECT lb_name, lb_team, lb_tackles, lb_sacks
    FROM linebacker
    GROUP BY lb_name;
	
--3. View Player Stats (Quarterbacks)
SELECT qb_name, qb_team, qb_passyds, qb_passtd
    FROM quarterback
    GROUP BY qb_name;
	
--4. View Player Stats (Runningbacks)
SELECT rb_name, rb_team, rb_rushyds, rb_rushtd
    FROM runningback
    GROUP BY rb_name;
	
--5. View Player Stats (Tight Ends)
SELECT te_name, te_team, te_recyds, te_rectd
    FROM tightend
    GROUP BY te_name;
	
--6. View Player Stats (Wide Receivers)
SELECT wr_name, wr_team, wr_recyds, wr_rectd
    FROM widereceiver
    GROUP BY wr_name;

--7. Add player to database add linebacker
INSERT INTO linebacker
VALUES('David Talabi', 'CLE', 21, 'LB', 1, 19, 13, 12, 40);

--8. Delete player from database, delete linebacker
DELETE FROM linebacker WHERE lb_name = 'David Talabi';

--9. Add player to database add defensive back
INSERT INTO defensiveback
VALUES('David Talabi', 'CLE', 21, 'DB', 1, 19, 13, 12, 40);

--10. Delete player from database, delete defensive back
DELETE FROM defensiveback WHERE db_name = 'David Talabi';

--11. Add player to database add quarterback
INSERT INTO quarterback
VALUES('David Talabi', 'CLE', 21, 'QB', 1, 19, 8000, 12, 40);

--12. Delete player from database, delete quarterback
DELETE FROM quarterback WHERE qb_name = 'David Talabi';

--13. Add player to database add runningback
INSERT INTO runningback
VALUES('David Talabi', 'CLE', 21, 'RB', 1, 19, 8000, 12, 40);

--14. Delete player from database, delete runningback
DELETE FROM runningback WHERE rb_name = 'David Talabi';

--15. Add player to database add tight end
INSERT INTO tightend
VALUES('David Talabi', 'CLE', 21, 'TE', 1, 19, 8000, 12, 40);

--16. Delete player from database, delete tight end
DELETE FROM tightend WHERE te_name = 'David Talabi';

--17. Add player to database add wide receiver
INSERT INTO widereceiver
VALUES('David Talabi', 'CLE', 21, 'WR', 1, 19, 8000, 12, 40);

--18. Delete player from database, delete wide receiver
DELETE FROM widereceiver WHERE wr_name = 'David Talabi';

--19. Create dream team
INSERT INTO jointeam
VALUES('Davids Superteam', 'Patrick Mahomes', 'Saquon Barkley', 'Darren Fells', 'Julio Jones', 'Jalen Ramsey', 'Jaylon Smith');

--20. Add user
INSERT INTO users
VALUES('David Talabi', 'Davids Superteam');

--21. Delete User
DELETE FROM users WHERE user_name = 'David Talabi';

--22. Play game (Blockfor)
INSERT INTO blockfor
VALUES('Marks team','Travis Kelce', 'Todd Gurley');

--23. Play game (Handballto)
INSERT INTO handballto
VALUES('Davids superteam','Patrick Mahomes', 'Saquon Barkley');

--24. Play game (Helptackleplayer)
INSERT INTO helptackleplayer
VALUES('Davids Superteam','Jaylon Smith', 'Jalen Ramsey');

--25. Play game (Throwto)
INSERT INTO throwto
VALUES('Davids Superteam','Patrick Mahomes', 'Julio Jones');

--26. Play game (Cover)
INSERT INTO cover
VALUES('Davids Superteam','Jalen Ramsey', 'Opposingteamwr');



