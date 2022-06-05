SELECT citizen_id, name, is_citizen FROM citizen
SELECT c.citizen_id, c.name, COUNT(citizen_id) AS 'count_of_children' FROM children INNER JOIN citizen c on children.parent_id = c.citizen_id GROUP BY c.citizen_id, c.name
SELECT citizen_id, name FROM citizen
SELECT citizen_id, name, has_driving_license FROM citizen
SELECT * FROM citizen WHERE citizen_id = :citizenId